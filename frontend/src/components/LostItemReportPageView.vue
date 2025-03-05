<template>

    <v-data-table
        :headers="headers"
        :items="lostItemReportPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'LostItemReportPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "deviceId", value: "deviceId" },
                { text: "createdAt", value: "createdAt" },
                { text: "status", value: "status" },
            ],
            lostItemReportPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/lostItemReportPages'))

            temp.data._embedded.lostItemReportPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.lostItemReportPage = temp.data._embedded.lostItemReportPages;
        },
        methods: {
        }
    }
</script>

