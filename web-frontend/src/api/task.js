export default function (instance){
    return {
        getTasks(){
            return instance.get('task/')
        },
        getTasksById(id){
            return instance.get('task/' + id)
        },
        triggerTaskById(id){
            return instance.post('/task/' + id + '/trigger')
        }
    }
}