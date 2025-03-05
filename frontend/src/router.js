
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import UserUserManager from "./components/listers/UserUserCards"
import UserUserDetail from "./components/listers/UserUserDetail"
import UserDeviceManager from "./components/listers/UserDeviceCards"
import UserDeviceDetail from "./components/listers/UserDeviceDetail"

import UserInfoView from "./components/UserInfoView"
import UserInfoViewDetail from "./components/UserInfoViewDetail"
import DeviceInfoView from "./components/DeviceInfoView"
import DeviceInfoViewDetail from "./components/DeviceInfoViewDetail"
import LossreportLostItemReportManager from "./components/listers/LossreportLostItemReportCards"
import LossreportLostItemReportDetail from "./components/listers/LossreportLostItemReportDetail"

import RentalDeviceRentalManager from "./components/listers/RentalDeviceRentalCards"
import RentalDeviceRentalDetail from "./components/listers/RentalDeviceRentalDetail"

import InsuranceInsuranceManager from "./components/listers/InsuranceInsuranceCards"
import InsuranceInsuranceDetail from "./components/listers/InsuranceInsuranceDetail"


import LostItemReportPageView from "./components/LostItemReportPageView"
import LostItemReportPageViewDetail from "./components/LostItemReportPageViewDetail"
import AlarmAlarmManager from "./components/listers/AlarmAlarmCards"
import AlarmAlarmDetail from "./components/listers/AlarmAlarmDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/users/users',
                name: 'UserUserManager',
                component: UserUserManager
            },
            {
                path: '/users/users/:id',
                name: 'UserUserDetail',
                component: UserUserDetail
            },
            {
                path: '/users/devices',
                name: 'UserDeviceManager',
                component: UserDeviceManager
            },
            {
                path: '/users/devices/:id',
                name: 'UserDeviceDetail',
                component: UserDeviceDetail
            },

            {
                path: '/users/userInfos',
                name: 'UserInfoView',
                component: UserInfoView
            },
            {
                path: '/users/userInfos/:id',
                name: 'UserInfoViewDetail',
                component: UserInfoViewDetail
            },
            {
                path: '/users/deviceInfos',
                name: 'DeviceInfoView',
                component: DeviceInfoView
            },
            {
                path: '/users/deviceInfos/:id',
                name: 'DeviceInfoViewDetail',
                component: DeviceInfoViewDetail
            },
            {
                path: '/lossreports/lostItemReports',
                name: 'LossreportLostItemReportManager',
                component: LossreportLostItemReportManager
            },
            {
                path: '/lossreports/lostItemReports/:id',
                name: 'LossreportLostItemReportDetail',
                component: LossreportLostItemReportDetail
            },

            {
                path: '/rentals/deviceRentals',
                name: 'RentalDeviceRentalManager',
                component: RentalDeviceRentalManager
            },
            {
                path: '/rentals/deviceRentals/:id',
                name: 'RentalDeviceRentalDetail',
                component: RentalDeviceRentalDetail
            },

            {
                path: '/insurances/insurances',
                name: 'InsuranceInsuranceManager',
                component: InsuranceInsuranceManager
            },
            {
                path: '/insurances/insurances/:id',
                name: 'InsuranceInsuranceDetail',
                component: InsuranceInsuranceDetail
            },


            {
                path: '/dashboards/lostItemReportPages',
                name: 'LostItemReportPageView',
                component: LostItemReportPageView
            },
            {
                path: '/dashboards/lostItemReportPages/:id',
                name: 'LostItemReportPageViewDetail',
                component: LostItemReportPageViewDetail
            },
            {
                path: '/alarms/alarms',
                name: 'AlarmAlarmManager',
                component: AlarmAlarmManager
            },
            {
                path: '/alarms/alarms/:id',
                name: 'AlarmAlarmDetail',
                component: AlarmAlarmDetail
            },



    ]
})
