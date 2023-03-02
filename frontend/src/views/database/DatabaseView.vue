<template>
  <div class="container mx-auto my-4">
    <div class="grid grid-cols-2 xl:grid-cols-4">
      <div class="m-4">
        <Button class="w-full" @click="router.push({ name: 'ancestries' })">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-people-group text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">ancestries</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full" @click="router.push({ name: 'languages' })">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-language text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">languages</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full" @click="router.push({ name: 'skills' })">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-hands text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">skills</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full" @click="router.push({ name: 'books' })">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-book text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">sources</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full" @click="router.push({ name: 'traits' })">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-tag text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">traits</span>
            </template>
          </Card>
        </Button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import Card from "primevue/card";
import Button from "primevue/button";

const router = useRouter();
</script>

<style scoped>
.p-card .p-card-content {
  padding: 0;
}
.p-card .p-card-title {
  text-align: center;
}
.p-button .p-card {
  background: transparent;
  box-shadow: 0 0 #0000;
  color: var(--primary-color-text);
}
</style>
