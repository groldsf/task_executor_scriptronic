<template>
  <div class="container">
    <h1>
      Tasks:
    </h1>
    <task-card v-for="task in tasks" :key="task.id" :task-info="task"></task-card>

  </div>
</template>

<script>
import TaskCard from "@/components/taskListPage/TaskCard";
export default {
  name: "TaskListPage",
  components: {TaskCard},
  data(){
    return{
      tasks:[]
    }
  },
  async mounted() {
    try {
      const res = await this.$api.task.getTasks()
      console.log(res.data)
      this.tasks = res.data
    } catch (error) {
      console.log(error)
    }
  }
}
</script>

<style scoped>

</style>