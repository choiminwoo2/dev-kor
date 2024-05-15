import axiosInstance from "./config/AxiosInstance.js";

async function createComment(formData){
    return await axiosInstance.post('/api/v1/comment',formData,{
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.data);
}

async function getCommentData(postId){
    let params = {
        params : {"postId": postId}
    }

    return axiosInstance.get(`/api/v1/comment`, params).then(res => res.data);
}

async function updateComment(formData){
    return await axiosInstance.patch('/api/v1/comment',formData,{
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.data);
}

async function requestDeleteComment(commentId){
    return await axiosInstance.delete(`/api/v1/comment/${commentId}`)
}

export {createComment, getCommentData, updateComment, requestDeleteComment}