<template>

    <v-card outlined>
        <v-card-title>
            LostItemReportPage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="DeviceId" v-model="item.deviceId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="CreatedAt" v-model="item.createdAt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'LostItemReportPageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/lostItemReportPages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

