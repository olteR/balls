<template>
  <Menubar :model="menuItems">
    <template #item="{ item }">
      <SplitButton
        v-if="item.subpages"
        class="menubutton"
        :model="item.subpages"
      >
        <Button @click="router.push(item.to)"
          ><div
            class="menulabel"
            :class="{
              active: router.currentRoute.value.path.startsWith(item.to),
            }"
          >
            {{ item.label }}
          </div></Button
        >
      </SplitButton>
      <Button v-else class="menubutton" @click="router.push(item.to)"
        ><div
          class="menulabel"
          :class="{ active: router.currentRoute.value.name === item.label }"
        >
          {{ item.label }}
        </div></Button
      >
    </template>
    <template #end>
      <div class="tab-menu-profile">
        logged in as
        <router-link to="/profile">
          {{ stateStore.getUser ? stateStore.getUser.name : "" }}.
          <i class="fa fa-user"></i
        ></router-link>
      </div>
    </template>
  </Menubar>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import Menubar from "primevue/menubar";
import Button from "primevue/button";
import SplitButton from "primevue/splitbutton";

const router = useRouter();
const stateStore = useStateStore();
const menuItems = ref([
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
          router.push({ name: "ancestries" });
        },
      },
      {
        label: "books",
        command: () => {
          router.push({ name: "books" });
        },
      },
      {
        label: "languages",
        command: () => {
          router.push({ name: "languages" });
        },
      },
      {
        label: "traits",
        command: () => {
          router.push({ name: "traits" });
        },
      },
    ],
  },
]);
</script>

<style>
.p-tabmenu {
  background-color: #1e1e1e;
  position: fixed;
  top: 0;
  z-index: 99;
  padding-top: 0.2rem;
}
.menubutton,
.menubutton > button {
  background-color: transparent !important;
  background-image: none !important;
  color: rgba(255, 255, 255, 0.87) !important;
}
.menulabel {
  border-bottom: 2px solid transparent;
}
.active {
  border-bottom: 2px solid #ce93d8;
  transition: border-bottom-color 0.5s ease;
}
</style>
