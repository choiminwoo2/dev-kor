import axiosInstance from "./config/AxiosInstance.js";



async function getBoard(boardUrl){
    return axiosInstance.get(`board/${boardUrl}`).then(res => res.data);
}




export {getBoard}