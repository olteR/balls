<template>
  <div class="container mx-auto my-4">
    <div class="grid grid-cols-2 lg:grid-cols-4">
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-people-group text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">races</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-hat-wizard text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">classes</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-hand-sparkles text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">spells</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-screwdriver-wrench text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">items</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-spaghetti-monster-flying text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">enemies</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-star text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">feats</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-id-card text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">backgrounds</span>
            </template>
          </Card>
        </Button>
      </div>
      <div class="m-4">
        <Button class="w-full">
          <Card class="w-full">
            <template #header>
              <span
                class="fa fa-face-dizzy text-center w-full my-8"
                style="font-size: 10rem"
              ></span>
            </template>
            <template #title>
              <span class="text-5xl">conditions</span>
            </template>
          </Card>
        </Button>
      </div>
    </div>
  </div>
</template>

<script setup>
import Card from "primevue/card";
import Button from "primevue/button";
</script>

<style scoped>
::v-deep(.p-card) {
  .p-card-content {
    padding: 0;
  }
  .p-card-title {
    text-align: center;
  }
}
::v-deep(.p-button) {
  .p-card {
    background: transparent;
    box-shadow: 0 0 #0000;
    color: var(--primary-color-text);
  }
}
</style>
