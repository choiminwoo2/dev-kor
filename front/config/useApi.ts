import axios from 'axios';
import {CustomError} from "./CustomError";
// axios 인스턴스 생성
const api = axios.create({
    baseURL: 'http://localhost:8080'
});

// Request Interceptors: 요청을 보내기 전에 실행되는 함수
api.interceptors.request.use(config => {
    // 요청 보내기 전에 필요한 작업 수행
    return config;
}, error => {
    // 요청 오류 발생 시 처리
    return Promise.reject(new CustomError(error.message, error.response.status));
});

// Response Interceptors: 응답을 받은 후 실행되는 함수
api.interceptors.response.use(response => {
    // 응답 받은 후 필요한 작업 수행
    return response;
}, error => {
    // 응답 오류 발생 시 처리
    return Promise.reject(new CustomError(error.message, error.response.status));
});

export default api;