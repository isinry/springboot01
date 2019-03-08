<template>
    <div class="app-container">
        <el-row style="margin-bottom: 10px;">
            <el-col :span="24">
                <el-button type="primary" @click="openAddUserModal" @toLoad="load"><i class="el-icon-plus">&nbsp;&nbsp;新增用户</i>
                </el-button>
                <user-form ref="form" v-model="userForm"></user-form>
            </el-col>
        </el-row>
        <el-table
            v-loading="listLoading"
            :data="list"
            element-loading-text="Loading"
            border
            fit
            highlight-current-row>
            <el-table-column align="center" label="ID" width="95">
                <template slot-scope="scope">
                    {{ scope.$index }}
                </template>
            </el-table-column>
            <el-table-column label="用户名">
                <template slot-scope="scope">
                    {{ scope.row.username }}
                </template>
            </el-table-column>
            <el-table-column label="密码" width="110" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.password }}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" prop="created_at" label="创建时间">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span>{{ scope.row.createTime }}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" prop="created_at" label="修改时间">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span>{{ scope.row.updateTime }}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" prop="created_at" label="删除时间">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span>{{ scope.row.deleteTime }}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" prop="active" label="操作">
                <template slot-scope="scope">
                    <el-button type="primary" @click="openEditUserModal(scope.row)" @toLoad="load"><i class="el-icon-edit">&nbsp;&nbsp;编辑</i></el-button>
                    <el-button type="danger" @click="handleDelete" @toLoad="load"><i class="el-icon-edit">&nbsp;&nbsp;删除</i></el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import {getList} from '@/api/table'
    import {getUserList} from '@/api/users'
    import UserForm from './component/userForm'

    export default {
        components: { UserForm },
        filters: {
            statusFilter(status) {
                const statusMap = {
                    published: 'success',
                    draft: 'gray',
                    deleted: 'danger'
                };
                return statusMap[status]
            }
        },
        data() {
            return {
                list: null,
                listLoading: true,
                userForm: {}
            }
        },
        created() {
            // this.fetchData()
            this.load();
        },
        methods: {
            load() {
                this.listLoading = true;
                getUserList().then(response => {
                    console.log(response);
                    this.list = response.data;
                    this.listLoading = false;
                });
            },

            /**
             * 打开新增用户窗口
             */
            openAddUserModal() {
                this.$refs.form.open();
            },
            /**
             * 打开编辑用户窗口
             */
            openEditUserModal(row) {
                this.userForm = {
                    id: row.id,
                    username: row.username,
                };
                this.$refs.form.open();
            },
            /**
             * 删除
             */
            handleDelete() {
                console.log("删除")
            }
        }
    }
</script>
