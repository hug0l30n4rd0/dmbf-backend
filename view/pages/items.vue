<template>
  <v-layout>
    <v-flex class="text-center">
      <!-- <img
        src="/v.png"
        alt="Vuetify.js"
        class="mb-5"
      > -->
      <!-- <blockquote class="blockquote">
        &#8220;First, solve the problem. Then, write the code.&#8221;
        <footer>
          <small>
            <em>&mdash;John Johnson</em>
          </small>
        </footer>
      </blockquote> -->

      <v-data-table
        :headers="headers"
        :items="items"
        sort-by="name"
        class="elevation-1"
      >
        <template v-slot:top>
          <v-toolbar flat color="white">
            <v-toolbar-title>MAGIC ITEMS</v-toolbar-title>
            <v-divider
              class="mx-4"
              inset
              vertical
            ></v-divider>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="600px">
              <template v-slot:activator="{ on }" >
                <v-btn color="primary" dark class="mb-2" v-on="on">New Item</v-btn>
              </template>
              <v-card>
                <v-form>
                  <v-card-title>
                    <span class="headline">{{ formTitle }}</span>
                  </v-card-title>

                  <v-card-text>
                    <v-container>
                      <!-- <v-form ref="form"> -->
                        <v-row>
                          <v-col cols="12" sm="6" md="8">
                              <!-- <ValidationProvider > -->
                                <v-text-field ref="name" v-model="editedItem.name" label="Name" :rules="[rules.required]" required></v-text-field>
                              <!-- </ValidationProvider> -->
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-switch ref="attunement" v-model="editedItem.attunement" class="ma-2" label="Attunement"></v-switch>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <!-- <ValidationProvider> -->
                              <v-select
                                ref="type"
                                v-model="editedItem.type"
                                :rules="[rules.required]"
                                :items="types"
                                item-text="name"
                                return-object
                                label="Type"
                              ></v-select>
                            <!-- </ValidationProvider> -->
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <!-- <ValidationProvider> -->
                              <v-select
                                ref="rarity"
                                v-model="editedItem.rarity"
                                :rules="[rules.required]"
                                :items="rarities"
                                item-text="name"
                                return-object
                                label="Rarity"
                              ></v-select>
                            <!-- </ValidationProvider> -->
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-switch v-model="editedItem.cursed" class="ma-2" label="Cursed"></v-switch>
                          </v-col>
                          <v-col cols="12" sm="6" md="12">
                            <!-- <ValidationProvider> -->
                              <v-textarea
                                ref="description"
                                outlined
                                v-model="editedItem.description"
                                :rules="[rules.required]"
                                label="Description"
                                value=""
                              ></v-textarea>
                            <!-- </ValidationProvider> -->
                          </v-col>
                        </v-row>
                      <!-- </v-form> -->
                    </v-container>
                  </v-card-text>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
                    <v-btn color="blue darken-1" text @click="save">Save</v-btn>
                  </v-card-actions>
                </v-form>
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>
        <template v-slot:item.action="{ item }">
          <v-icon
            small
            class="mr-2"
            @click="editItem(item)"
          >
            edit
          </v-icon>
          <v-icon
            small
            @click="deleteItem(item)"
          >
            delete
          </v-icon>
        </template>

        <template v-slot:no-data>
          <v-btn color="primary" @click="initialize">Reset</v-btn>
        </template>
      </v-data-table>
    </v-flex>
  </v-layout>
</template>

<script>
  import axios from 'axios'
  import ItemRarity from '@/model/ItemRarityMock.json'
  import ItemType from '@/model/ItemTypeMock.json'
  // import ValidationProvider from 'vee-validate'
  // import ValidationObserver from 'vee-validate'


  export default {
    // components: {
    //   ValidationProvider,
    //   ValidationProvider
    // },
    authenticated: true,
    data: () => ({
      rarity: null,
      rarities: [],
      type: null,
      types: [],
      attunement: null,
      cursed: null,
      dialog: false,
      headers: null,
      desserts: [],
      items: [],
      editedIndex: -1,
      formHasErrors: false,
      editedItem: {
        name: '',
        type: null,
        rarity: null,
        attunement: false,
        cursed: false,
        description: '',
      },
      defaultItem: {
        name: '',
        type: null,
        rarity: null,
        attunement: false,
        cursed: false,
        description: '',
      },
      rules: {
          required: value => !!value || 'Required.',
          counter: value => value.length <= 20 || 'Max 20 characters',
      },
    }),

    computed: {
      formTitle () {
        return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
      },
      form () {
        return {
          name: this.name,
          attunement: this.attunement,
          cursed: this.cursed,
          type: this.type,
          rarity: this.rarity,
          description: this.description,
        }
      },
    },

    watch: {
      dialog (val) {
        val || this.close()
      },
    },

    created () {
      this.initialize()
    },

    methods: {
      getHeaders() {
        return [
          {
            text: 'Name',
            align: 'left',
            sortable: true,
            value: 'name',
          },
          { text: 'Type', value: 'type.name', align: 'center' },
          { text: 'Rarity', value: 'rarity.name', align: 'center' },
          { text: 'Attunement', value: 'attunement', align: 'center' },
          { text: 'Cursed', value: 'cursed', align: 'center' },
          { text: 'Actions', value: 'action', align: 'center', sortable: false },
        ]
      },

      getItemTypes () {
        this.$http.get('/resource/item-type/')
          .then(res => {
            this.types = res.data
          });
      },

      getItemRarities () {
        this.$http.get('/resource/item-rarity/')
          .then(res => {
            this.rarities = res.data
          });
      },

      getData () {
        this.$http.get('/item/')
          .then(res => {
            console.log(res)
            this.items = res.data._embedded.item //data.content
          });
      },

      initialize () {
        this.getItemTypes()
        this.getItemRarities()
        this.getData()
        this.headers = this.getHeaders()
      },

      editItem (item) {
        this.editedIndex = this.items.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },

      deleteItem (item) {
        const index = this.items.indexOf(item)
        confirm('Are you sure you want to delete this item?') && this.items.splice(index, 1)
      },

      close () {
        this.dialog = false
        setTimeout(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        }, 300)
      },
      // validate () {
      //   return this.$refs.name.validate()
      //     && this.$refs.type.validate()
      //     && this.$refs.rarity.validate()
      //     && this.$refs.description.validate()

      // },
      save () {

          console.log(this.$refs.name.validate())
          //this.$validator.validateAll()

          // if (this.editedIndex > -1) {
          //   Object.assign(this.items[this.editedIndex], this.editedItem)
          // } else {
          //   console.log(JSON.stringify(this.editedItem))

            // this.$http.post('/item/', JSON.stringify(this.editedItem), {headers:{'Content-Type': 'application/json; charset=utf-8'}})
            // .then(res => {
            //   console.log('salvo com sucesso')
            //   this.getData()
            // })
            // .catch((err) => console.log(err));
          // }
          //this.close()
        // }
      },
    },
  }

</script>>
