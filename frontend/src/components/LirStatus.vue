<template>
    <div>
        <v-card-title>
            LirStatus
        </v-card-title>
        <v-card-text>
            <div v-if="editMode">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="lirStatusList"
                ></v-select>
            </div>
            <div v-else>
                LirStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'LirStatus',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            lirStatusList : [ "reported",  "resolved",  "found",  "longTermLost", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.lirStatusList[0];
            } else {
                this.newValue = this.value;
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },
        methods: {
        }
    }
</script>