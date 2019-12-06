import Vue from 'vue'
import axios from 'axios'

// axios.defaults.baseURL = 'https://curso-vue-e7de3.firebaseio.com/'
// axios.defaults.headers.common['Authorization'] = 'abc123'
// axios.defaults.headers.get['Accepts'] = 'application/json'

Vue.use({
    install(Vue) {
        /*************************************************
         * * * * * PROJECT-BACKEND * * * * * 
         **************************************************/
        Vue.prototype.$http = axios.create({
            baseURL: 'http://localhost:8081',
            headers: {
                "Authorization": "abc123",
                // "Access-Control-Allow-Credentials":"true",
                // "Access-Control-Allow-Origin":"http://localhost:3000",
                // "Access-Control-Allow-Headers":"Content-Type"
            }
        })

        Vue.prototype.$http.interceptors.request.use(config => {
            // if(config.method == 'post') {
            //     config.method = 'put'
            // }
            console.log('~Trying: ' + config.method + ' @ ' + config.baseURL+config.url)
            return config
        }, error => Promise.reject(error))

        Vue.prototype.$http.interceptors.response.use(res => {
            // const array = []
            // for(let chave in res.data) {
            //     array.push({ id: chave, ...res.data[chave] })
            // }

            // res.data = array
            return res
        }, error => Promise.reject(error))

      
    }
})