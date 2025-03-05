<template>
    <v-card outlined>
        <v-card-title>
            Report
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Status offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <Date label="CreatedAt" v-model="value.createdAt" :editMode="editMode"/>
            <Number label="DeviceId" v-model="value.deviceId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="report"
            >
                Report
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ReportCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.userId = 0;
            this.value.status = {};
            this.value.createdAt = '2025-03-06';
            this.value.deviceId = 0;
        },
        watch: {
        },
        methods: {
            report() {
                this.$emit('report', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

