import colors from 'vuetify/es5/util/colors'


//require('dotenv').config()

export default {
  mode: 'universal',
  /*
  ** Headers of the page
  */
  head: {
    titleTemplate: '%s - ' + process.env.npm_package_name,
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: process.env.npm_package_description || '' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },
  /*
  ** Customize the progress-bar color
  */
  loading: { color: '#fff' },
  /*
  ** Global CSS
  */
  css: [
    { src: '~static/css/rpg-awesome.min.css' }
  ],
  /*
  ** Plugins to load before mounting the App
  */
  plugins: [
    '@/plugins/axios',
    '@/plugins/vee-validate',
    //{src: '~plugins/vee-validate.js', ssr: true},
  ],
  /*
  ** Nuxt.js dev-modules
  */
  buildModules: [
    '@nuxtjs/vuetify',

  ],
  /*
  ** Nuxt.js modules
  */
  modules: [
    // Doc: https://axios.nuxtjs.org/usage
    '@nuxtjs/axios',
    '@nuxtjs/auth',
    //'nuxt-oauth'
    //'nuxt-validate',
    // ['nuxt-validate', {
      //lang: 'en',
      // nuxti18n: {
      //   locale: {
      //     'zh-CN': 'zh_CN'
      //   }
      // }
      // regular vee-validate options
    // }]
  ],

  /*
  ** Axios module configuration
  ** See https://axios.nuxtjs.org/options
  */
  axios: {
    baseURL: 'http://127.0.0.1:3333/api',
    //backendURL: 'http://127.0.0.1:8081/'
  },

  // oauth: {
  //   sessionName: 'WidgetCoSession',
  //   secretKey: process.env.SECRET_KEY,
  //   oauthHost: process.env.OAUTH_ISSUER,
  //   oauthClientID: process.env.CLIENT_ID,
  //   //oauthClientSecret: process.env.CLIENT_SECRET,
  //   scopes: ['openid', 'profile'],
  // },


  auth: {
    strategies: {
      local: {
        endpoints: {
          login: { url: 'login', method: 'post', propertyName: 'data.token' },
          user: { url: 'me', method: 'get', propertyName: 'data' },
          logout: false
        }
      }
    }
  },

  /*
  ** vuetify module configuration
  ** https://github.com/nuxt-community/vuetify-module
  */
  vuetify: {
    customVariables: ['~/assets/variables.scss'],
    theme: {
      dark: true,
      themes: {
        dark: {
          primary: colors.grey.darken3,
          accent: colors.grey.lighten1,
          secondary: colors.blueGrey.lighten2,
          info: colors.blueGrey.darken1,
          warning: colors.grey,
          error: colors.black,
          success: colors.blueGrey.lighten4
        }
      }
    }
  },
  /*
  ** Build configuration
  */
  build: {
    /*
    ** You can extend webpack config here
    */
    extend (config, ctx) {
    }
  }
}
