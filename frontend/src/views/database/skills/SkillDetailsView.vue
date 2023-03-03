<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="skillStore.getSkill">
      <template #title>
        <div class="text-5xl">
          {{ skillStore.getSkill.name }}
        </div>
      </template>
      <template #content>
        <div
          v-if="skillStore.getSkill.description"
          v-html="skillStore.getSkill.description"
        ></div>
        <div class="pt-4 text-right">
          <div class="font-bold">source</div>
          <div>
            {{
              skillStore.getSkill.source + " pg. " + skillStore.getSkill.page
            }}
          </div>
        </div>
      </template>
    </Card>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import { useSkillStore } from "@/stores/database/skill";
import Card from "primevue/card";

const router = useRouter();
const stateStore = useStateStore();
const skillStore = useSkillStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await skillStore.fetchOne(params.id);
  stateStore.getBreadcrumbs.push({
    name: "skill",
    label: skillStore.getSkill.name,
    params: params,
  });
  stateStore.setLoading(false);
});
</script>
