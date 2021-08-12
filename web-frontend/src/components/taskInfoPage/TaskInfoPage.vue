<template>
  <div>
    <h1>task info</h1>
    <div class="row">
      <div class="col">
        <p>id: {{ id }}</p>
      </div>
      <div class="col">
        <p>name: {{ task.name }}</p>
      </div>
    </div>
    <div class="btn-group" role="group" aria-label="Basic example">
      <button class="btn btn-dark" @click="trigger">trigger task</button>
    </div>
    <div id="instance-cards" class="row">
      <task-instance-card v-for="taskInstance in taskInstances" :key="taskInstance.id"
                          :task-instance-info="taskInstance"></task-instance-card>
    </div>


  </div>
</template>

<script>
import TaskInstanceCard from "@/components/taskInfoPage/TaskInstanceCard";

export default {
  name: "TaskInfoPage",
  components: {TaskInstanceCard},
  data() {
    return {
      id: this.$route.params.id,
      task: {
        name: "null"
      },
      taskInstances: []
    }
  },
  async mounted() {
    try {
      const task = await this.$api.task.getTasksById(this.id)
      console.log(task.data)
      this.task = task.data
      const taskInstances = await this.$api.taskInstance.getTaskInstancesByTaskId(this.id)
      console.log(taskInstances.data)
      this.taskInstances = taskInstances.data
    } catch (error) {
      console.log(error)
    }
  },
  methods: {
    trigger: async function () {
      const taskInstance = await this.$api.task.triggerTaskById(this.id)
      console.log(taskInstance.data)
      this.taskInstances.push(taskInstance.data)
    }
  }

}
</script>

<style scoped>
#instance-cards {
  background-color: darkgrey;
}
</style>