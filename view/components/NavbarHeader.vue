<template>
    <!-- <v-container> -->

        <v-template  v-if="isAuthenticated">
            <v-menu offset-y>
                <template v-slot:activator="{ on }">
                    <v-btn text v-on="on">
                        {{ loggedInUser.username }}
                        <v-icon right>mdi-account-circle</v-icon>
                    </v-btn>
                </template>
                <v-list>
                    <v-list-item>
                        <v-btn text to="/">
                            <v-icon left>mdi-account-outline</v-icon>
                            Nuxt Auth
                        </v-btn>
                    </v-list-item>
                    <v-list-item>
                        <v-btn text to="/profile">
                            <v-icon left>mdi-face-profile</v-icon>
                            My Profile
                        </v-btn>
                    </v-list-item>
                    <v-list-item>
                       <v-btn text @click="logout">
                            <v-icon left>mdi-logout</v-icon>
                            Logout
                        </v-btn>
                    </v-list-item>
                </v-list>
            </v-menu>
        </v-template>
        <v-template v-else>
            <v-btn text to="/register">
              <v-icon left>mdi-account-plus</v-icon>
              Register
            </v-btn>
            <v-btn text to="/login">
              <v-icon left>mdi-login-variant</v-icon>
              Log In
            </v-btn>
        </v-template>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'NavbarHeader',

  computed: {
    ...mapGetters(['isAuthenticated', 'loggedInUser'])
  },

  methods: {
    async logout() {
      await this.$auth.logout();
    },
  }
}
</script>



