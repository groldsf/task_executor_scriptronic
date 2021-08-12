import Vue from 'vue'
import App from './App.vue'

import VueRouter from "vue-router"
import router from "@/router/index"

import ApiPlugin from '@/plugins/api'
import store from '@/store/index'

import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

Vue.config.productionTip = false

Vue.use(ApiPlugin)
Vue.use(VueRouter)


new Vue({
  render: h => h(App),
  el: '#app',
  router,
  store
})
