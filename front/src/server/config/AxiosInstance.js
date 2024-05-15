import axios from 'axios';
import qs from "qs";

// Axios 인스턴스 생성
const axiosInstance = axios.create({
    // 여기에 필요한 Axios 설정을 추가하세요 (예: baseURL)
    baseURL: 'http://localhost:8080/',
});

// 요청 인터셉터: 요청 전에 실행됨
axiosInstance.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);
axiosInstance.defaults.paramsSerializer = params => {
    return qs.stringify(params);
}

// 응답 인터셉터: 응답을 받은 후 실행됨
axiosInstance.interceptors.response.use(
    response => {
        return response;
    },
    error => {
        if (error.response) {
            console.error('서버 응답 오류:', error.response.data);
        } else if (error.request) {
            console.error('요청 오류:', error.request);
        } else {
            console.error('요청 설정 오류:', error.message);
        }
        return Promise.reject(error);
    }
);

export default axiosInstance;