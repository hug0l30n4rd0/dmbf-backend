<template>
  
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4 lg4>
            <v-card>
                <Notification :message="error" v-if="error"/>
              </v-card>
            <v-card class="elevation-1 pa-3">
              <v-card-text>
                <div class="layout column align-center">
                  <img src="../static/m.png" alt="Vue Material Admin" width="120" height="120">
                  <h1 class="flex my-4 primary--text">Dungeon Master's Best Friend</h1>
                </div>
                <v-form method="post">
                  <v-text-field append-icon="mdi-email" name="login" label="Login" type="text"
                                v-model="username"></v-text-field>
                  <v-text-field append-icon="mdi-lock" name="password" label="Password" id="password" type="password"
                                v-model="password"></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <!-- <v-btn icon>
                  <v-icon color="blue">fa fa-facebook-square fa-lg</v-icon>
                </v-btn>
                <v-btn icon>
                  <v-icon color="red">fa fa-google fa-lg</v-icon>
                </v-btn>
                <v-btn icon>
                  <v-icon color="light-blue">fa fa-twitter fa-lg</v-icon>
                </v-btn> -->
                <!-- <v-spacer></v-spacer> -->
                <v-btn block color="primary" @click="login" :loading="loading">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
</template>

<script>
  import Notification from '~/components/Notification'
  
  export default {
    components: {
      Notification,
    },

    layout: 'default',
    
    data: () => ({
      loading: false,
      error: null,
      username: 'holderhek2@gmail.com',
      password: 'exit2112',
      
    }),

    methods: {
      async login() {
        this.loading = true;
        try {

          console.log(this.username + ' ~ ' +this.password)
          await this.$auth.loginWith('local', {
            data: {
              email: this.username,
              password: this.password
            },
          })
          console.log(this.username + ' : ' +this.password)
          this.$router.push('/')
        } catch (e) {
          this.loading = false
          this.error = e.response.data.message
        }
      }

    }

  };
</script>
<style scoped lang="css">
  #login {
    height: 50%;
    width: 100%;
    position: absolute;
    top: 0;
    left: 0;
    content: "";
    z-index: 0;
  }
</style>