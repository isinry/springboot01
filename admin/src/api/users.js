import request from '@/utils/request'

export function getUserList(params) {
    return request({
        url: "/users",
        method: "get",
        params
    })
}

export function addUser(params) {
    return request({
        url: "/users",
        method: "post",
        params
    });
}

export function editUser(params) {
    return request({
        url: "/users/" + params.id,
        method: "post",
        params
    });
}
