<template>
  <div class="flex h-screen">
    <div class="m-auto justify-items-center">
      <h1 class="text-9xl text-center select-none">balls.</h1>
      <span class="p-float-label m-8">
        <InputText id="name" type="text" v-model="name" class="w-full" />
        <label for="name">username</label>
      </span>
      <span class="p-float-label m-8">
        <Password
          id="password"
          v-model="password"
          :feedback="false"
          toggleMask
          class="w-full"
        />
        <label for="password">password</label>
      </span>
      <Button
        label="login"
        class="float-right p-button-primary mr-8"
        @click="loginUser()"
      />
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import InputText from "primevue/inputtext";
import Password from "primevue/password";
import Button from "primevue/button";
import { useUserStore } from "@/stores/user";

const userStore = useUserStore();
const name = ref();
const password = ref();

async function loginUser() {
  await userStore.loginUser({ name: name.value, password: password.value });
}
</script>
