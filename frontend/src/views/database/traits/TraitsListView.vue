<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">traits</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="traitStore.getTraits"
            responsiveLayout="scroll"
            sortMode="multiple"
            removableSort
          >
            <Column field="name" header="name" :sortable="true"></Column>
            <Column field="categories" header="categories" :sortable="true">
              <template #body="slotProps">
                <div v-if="slotProps.data.categories.length > 0">
                  <span
                    v-for="category in slotProps.data.categories"
                    :key="category"
                    >{{ formatEnum(category)
                    }}<span
                      v-if="
                        slotProps.data.categories.indexOf(category) + 1 !==
                        slotProps.data.categories.length
                      "
                      >,
                    </span></span
                  >
                </div>
                <div v-else>n/a</div>
              </template>
            </Column>
            <Column field="source" header="source">
              <template #body="slotProps">
                {{ slotProps.data.source + " pg. " + slotProps.data.page }}
              </template>
            </Column>
            <Column>
              <template #body="slotProps">
                <router-link :to="'/database/trait/' + slotProps.data.id"
                  ><i class="fa fa-ellipsis"></i
                ></router-link>
              </template>
            </Column>
          </DataTable>
        </div>
      </template>
    </Card>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useStateStore } from "@/stores/state";
import { useTraitStore } from "@/stores/database/trait";
import { formatEnum } from "@/utils/util";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const stateStore = useStateStore();
const traitStore = useTraitStore();

onMounted(async () => {
  stateStore.setLoading(true);
  await traitStore.fetchTraits();
  stateStore.setLoading(false);
});
</script>

<style scoped></style>
