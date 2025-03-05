<template>

    <v-card outlined>
        <v-card-title>
            UserInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Email" v-model="item.email" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResidentNumber" v-model="item.residentNumber" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'UserInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/userInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

