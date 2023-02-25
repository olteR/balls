<template>
  <Toast position="bottom-center" />
  <div class="card">
    <div v-if="router.currentRoute.value.name !== 'login'">
      <Menubar :model="items">
        <template #item="{item}">
          <SplitButton v-if="item.subpages" class="menubutton" :model="item.subpages">
            <Button @click="router.push(item.to)"><div class="menulabel" :class="{ active: router.currentRoute.value.path.startsWith(item.to) }">{{ item.label }}</div></Button>
          </SplitButton>
          <Button v-else class="menubutton" @click="router.push(item.to)"><div class="menulabel" :class="{ active: router.currentRoute.value.name === item.label }">{{ item.label }}</div></Button>
        </template>
        <template #end>
          <div class="tab-menu-profile"
            >logged in as
            <router-link to="/profile">
              {{ userStore.getUser ? userStore.getUser.name : "" }}.
              <i class="fa fa-user"></i></router-link
          ></div>
        </template>
      </Menubar>
    </div>
    <div class="view">
      <RouterView />
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { RouterView, useRouter } from "vue-router";
import axios from "axios";
import { useToast } from "primevue/usetoast";
import { useUserStore } from "@/stores/user";
import Toast from "primevue/toast";
import Menubar from "primevue/menubar";
import Button from "primevue/button";
import SplitButton from "primevue/splitbutton";

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
    subpages: [
      {
        label: "ancestries",
        command: () => {
          router.push({name:"ancestries"});
        }
      },
      {
        label: "books",
        command: () => {
          router.push({name:"books"});
        }
      },
      {
        label: "languages",
        command: () => {
          router.push({name:"languages"});
        }
      },
      {
        label: "traits",
        command: () => {
          router.push({name:"traits"});
        }
      },
    ],
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
.menubutton, .menubutton > button {
  background-color: transparent !important;
  background-image: none !important;
  color: rgba(255, 255, 255, 0.87) !important;
}
.menulabel {
  border-bottom: 2px solid transparent;
}
.active {
  border-bottom: 2px solid #CE93D8;
  transition: border-bottom-color 0.5s ease;
}
</style>
