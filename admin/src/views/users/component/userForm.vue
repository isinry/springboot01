<template>
    <el-dialog
        :title="title"
        :visible.sync="dialogVisible"
        width="30%"
        @close="close"
        :before-close="handleClose">

        <el-form ref="form" :rules="rules" :model="form" label-width="80px">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPassword">
                <el-input v-model="form.checkPassword"></el-input>
            </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
    <el-button @click="close('form')">取 消</el-button>
    <el-button type="primary" @click="ok('form')" :disabled="buttonDisabled">确 定</el-button>
  </span>
    </el-dialog>
</template>

<script>
    import {addUser, editUser} from "../../../api/users";

    export default {
        name: "userForm",
        data() {
            // 自定义校验
            let checkPassword = (rule, value, rollback) => {
                console.log(rule, value);
                if (value === this.form.password) {
                    rollback();
                } else {
                    rollback(new Error("两次密码输入的不一致"))
                }
            };
            return {
                dialogVisible: false,
                buttonDisabled: false,
                title: "",
                form: {
                    id: 0,
                    username: "",
                    password: "",
                    checkPassword: ""
                },
                rules: {
                    username: [{required: true, message: '用户名不能为空'}],
                    password: [{required: true, message: '用户密码不能为空'}],
                    checkPassword: [
                        {required: true, message: '确认密码不能为空'},
                        {validator: checkPassword, trigger: "blur"}
                    ]
                }
            }
        },
        props: {
            value: {
                type: Object,
                default: {}
            },
        },
        watch: {
            value (item) {
                this.form = item;

                if (this.form.id > 0) {
                    this.title = "编辑用户";
                } else {
                    this.title = "新增用户";
                }
            },
        },
        methods: {
            open () {
                this.dialogVisible = true;
            },
            close () {
                this.form = {};
                this.dialogVisible = false;
            },
            handleClose () {
                // 关闭前置操作
            },

            ok (field) {
                this.$refs[field].validate(valid => {
                    if (valid) {
                        this.submitUser();
                    } else {
                        return false;
                    }
                });
            },

            /**
             * 提交用户数据
             */
            submitUser () {
                if (this.form.id > 0) {
                    this.editUserFunc();
                } else {
                    this.addUserFunc();
                }
            },

            addUserFunc () {
                this.buttonDisabled = true;
                let f = this.form;
                addUser({username: f.username, password: f.password}).then(response => {
                    if (response.code === 200) {
                        this.$message.success("新增成功");
                        this.$emit("toLoad");
                        this.close();
                    } else {
                        this.$message.error("新增失败");
                    }
                    this.buttonDisabled = false;
                });
            },

            editUserFunc () {
                this.buttonDisabled = true;
                let f = this.form;
                editUser({id: f.id, username: f.username, password: f.password}).then(response => {
                    if (response.code === 200) {
                        this.$message.success("编辑成功");
                        this.close();
                        this.$emit("toLoad");
                    } else {
                        this.$message.error("编辑失败");
                    }
                    this.buttonDisabled = false;
                });
            }
        }
    }
</script>

<style scoped>

</style>
