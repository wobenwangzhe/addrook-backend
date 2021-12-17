// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//在main.js中先引入element-ui的功能
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//引入axios的包
import axios from "axios";

Vue.config.productionTip = false
//每个页面都能直接使用 element-ui
Vue.use(ElementUI);
//将 axios 加入到 Vue对象的属性中
Vue.prototype.$axios=axios;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  components: { App },
  template: '<App/>'
})
