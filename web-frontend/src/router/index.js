import VueRouter from "vue-router";
import TaskListPage from "@/components/taskListPage/TaskListPage";
import TaskInfoPage from "@/components/taskInfoPage/TaskInfoPage";
import TaskInstanceListPage from "@/components/taskInstancesListPage/TaskInstanceListPage";
import TaskInstanceInfoPage from "@/components/taskInstanceInfoPage/TaskInstanceInfoPage";

export default new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/tasks/'
        },
        {
            path: '/tasks/',
            name: 'taskListPage',
            component: TaskListPage
        },
        {
            path: '/tasks/:id',
            name: 'taskInfoPage',
            component: TaskInfoPage
        },
        {
            path: '/taskInstances',
            name: 'taskInstanceListPage',
            component: TaskInstanceListPage
        },
        {
            path: '/taskInstances/:id',
            name: 'taskInstanceInfoPage',
            component: TaskInstanceInfoPage
        },
        {
            path: '/*',
            redirect: '/tasks/'
        }
    ]
})