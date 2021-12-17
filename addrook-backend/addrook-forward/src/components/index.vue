<template>
  <div id="in">
    <el-container>
      <el-header>
        <h1>个人通通讯录系统</h1>
      </el-header>
      <el-main>
          <el-container>
            <el-header style="text-align: left">
              <el-button icon="el-icon-circle-plus" type="primary" @click="add"  round>&nbsp;添加新联系人</el-button>
            </el-header>
            <el-main>
              <el-table
                :data="tableData"
                style="width: 100%">
                <el-table-column
                  prop="no"
                  label="序号"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="姓名"
                  width="180">
                </el-table-column>
                <el-table-column
                  prop="cellphone"
                  label="手机号码"
                  width="200">
                </el-table-column>
                <el-table-column
                  prop="address"
                  label="地址">
                </el-table-column>
                <el-table-column
                  prop="operate"
                  label="操作"
                  width="300">
                    <template slot-scope="scope">
                      <el-button  type="warning" @click="update(scope.row)" size="small" round>修改</el-button>
                      &nbsp;
                      <el-button  type="warning" @click="deleteOne" size="small" round>删除</el-button>
                    </template>
                </el-table-column>
              </el-table>
              <div style="margin-top: 50px">
                <el-button type="primary" icon="el-icon-arrow-left">上一页</el-button>
                总共有{{total}}个联系人,可以分{{pages}}页。&nbsp;现在页码为{{current}},每页可显示{{size}}个联系人
                <el-button type="primary">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
              </div>
            </el-main>
          </el-container>
      </el-main>
    </el-container>

  </div>
</template>

<script>
export default {
  name: "index",
  //  Vue 生命周期
  //网页渲染时从后端拿到表格信息
  created(){
      var pageNum=1;
      var pageSize=5;
    this.$axios.post("http://localhost/user/page/"+pageNum+"/"+pageSize,{})
                .then(resp=>{
      //获得后端返回的 responseVO
      var responseVO=resp.data;

      if (responseVO.code==20000) {
        //异步查询如果后台返回响应成功
        //获得分页对象
        var pageVO = responseVO.data;
        //获得分页列表
        var records = pageVO.records;

        //将分页列表加入表格的tableData中
        let list =[];
        for (let num=0;num<records.length;num++){
          //遍历records
          let record=records[num];
          //加入序号
          record.no=(pageVO.current-1)*pageVO.size+num+1;
          //添加到tableData中
          list[num]=record;
        }
        this.tableData=list;
        this.total=pageVO.total;
        this.pages=pageVO.pages;
        this.current=pageVO.current;
        this.size=pageVO.size;
      }
    });
  },


  methods:{

      add:function () {
        alert("点击添加联系人");
      },
      deleteOne(){
        alert("点击删除按钮");
      },
      update(userVO){
        console.log(userVO);
      }
  },
    data(){
      return {
        tableData: []
      }
    }
  }
</script>

<style scoped>

</style>
