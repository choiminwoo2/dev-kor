import axiosInstance from "./config/AxiosInstance.js";
import {params} from "svelte-spa-router";

async function createPost(formData){
    return await axiosInstance.post('/api/v1/post',formData).then(res => res.data);
}

async function getPost(postNum, boardUrl){
    let params = {
        params : {"boardUrl": boardUrl}
    }
    console.log("params=" + params);
    return axiosInstance.get(`api/v1/post/${postNum}`, params).then(res => res.data);
}

async function deletePost(postNum){
    return axiosInstance.delete(`api/v1/post/${postNum}`).then(res => res.data);
}

async function updatePost(postNum, formData){
    return axiosInstance.put(`/api/v1/post/${postNum}`, formData, {
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.data);
}

export {getPost, createPost, deletePost, updatePost}