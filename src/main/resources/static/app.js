new Vue({
    el: '#app',
    data: {
        userSelected: false,
        users: null,
        mode: null
    },
    methods: {
        loadData: function () {
            var _this = this;
            this.$http.get('/user/all').then(response => {
                _this.users = response.data
            }, response => {
                console.log("broken")
            });
        },
        selectUser: function (id, event) {
            var _this = this;
            this.$http.get('/user/id/' + id).then(response => {
                _this.selectedUser = response.data;
                _this.userSelected = true;
                this.setMode('edit');
            }, response => {
                console.log("broken")
            });
        },
        saveUser: function (event) {
            var _this = this;
            this.$http.put('/user', _this.selectedUser).then(response => {
                _this.selectedUser = null;
                _this.userSelected = false;
                this.setMode(null);
            }, response => {
                console.log("broken")
            });
        },
        deleteUser: function (event) {
            var _this = this;
            this.$http.delete('/user/id/' + _this.selectedUser.id).then(response => {
                _this.selectedUser = null;
                _this.userSelected = false;
                this.setMode(null);
            }, response => {
                console.log("broken")
            });
        },
        setMode: function(mode, event) {
            var _this = this;
            _this.mode = mode;
            if (mode != 'edit') {
                _this.selectedUser = {};
            }
        }
    },
    mounted: function () {
        this.loadData();
        setInterval(function () {
            this.loadData();
        }.bind(this), 500);
    }
});