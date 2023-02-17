<template>
  <Toast position="bottom-center" />
  <div class="card">
    <div v-if="router.currentRoute.value.name !== 'login'">
      <TabMenu :model="items" class="inline w-full" />
      <span class="tab-menu-profile"
        >logged in as
        <router-link to="/profile">
          {{ userStore.getUser ? userStore.getUser.name : "" }}.
          <i class="fa fa-user"></i></router-link
      ></span>
    </div>
    <div class="view">
      <RouterView />
    </div>
  </div>
</template>

<script setup>
import { RouterView, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import { onMounted, ref } from "vue";
import Toast from "primevue/toast";
import TabMenu from "primevue/tabmenu";
import { useToast } from "primevue/usetoast";
import axios from "axios";

const router = useRouter();
const toast = useToast();
const userStore = useUserStore();
const items = ref([
  {
    label: "campaigns",
    to: "/campaigns",
  },
  {
    label: "characters",
    to: "/characters",
  },
  {
    label: "database",
    to: "/database",
  },
]);

onMounted(() => {
  if (!userStore.isLoggedIn) {
    if (userStore.getUser != null) {
      userStore.logoutUser();
      toast.add({
        severity: "error",
        summary: "login expired",
        detail: "please log in again.",
        group: "bc",
        life: 3000,
      });
    }
    router.push("/login");
  } else {
    axios.defaults.headers.common["Authorization"] =
      "Bearer " + userStore.getJwt;
  }
});
</script>

<style>
.tab-menu-profile {
  position: fixed;
  top: 0;
  right: 0;
  padding: 0.75rem 1.25rem;
  z-index: 999;
}
.p-tabmenu {
  background-color: #1e1e1e;
  position: fixed;
  top: 0;
  z-index: 99;
  padding-top: 0.2rem;
}
.view {
  position: relative;
  top: 4rem;
}
</style>
