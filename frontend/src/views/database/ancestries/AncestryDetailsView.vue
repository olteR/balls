<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="ancestryStore.getAncestry">
      <template #title>
        <div class="text-5xl text-center">
          {{ ancestryStore.getAncestry.name }}
        </div>
      </template>
      <template #content>
        <div class="flex">
          <div>
            <div
              class="text-justify italic"
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Flavor'
                )
              "
              v-html="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Flavor'
                ).entry
              "
            ></div>
            <Divider type="solid" align="center">
              <i class="fa fa-chevron-down"></i>
            </Divider>
            <div
              class="text-justify"
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Info'
                )
              "
              v-html="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Info'
                ).entry
              "
            ></div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'You Might...'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">YOU MIGHT...</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'You Might...'
                  ).entry
                "
              ></div>
            </div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Others Probably...'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">OTHERS PROBABLY...</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Others Probably...'
                  ).entry
                "
              ></div>
            </div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Physical Description'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">PHYSICAL DESCRIPTION</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Physical Description'
                  ).entry
                "
              ></div>
            </div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Society'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">SOCIETY</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Society'
                  ).entry
                "
              ></div>
            </div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Alignment and Religion'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">ALIGNMENT AND RELIGION</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Alignment and Religion'
                  ).entry
                "
              ></div>
            </div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Names'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">NAMES</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Names'
                  ).entry
                "
              ></div>
              <div
                v-if="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Sample Names'
                  )
                "
              >
                <div class="text-xl mt-4 mb-2">SAMPLE NAMES</div>
                <div
                  class="text-justify"
                  v-html="
                    ancestryStore.getAncestry.description.find(
                      (f) => f.name === 'Sample Names'
                    ).entry
                  "
                ></div>
              </div>
            </div>
            <div
              v-if="
                ancestryStore.getAncestry.description.find(
                  (f) => f.name === 'Ethnicities'
                )
              "
            >
              <div class="text-3xl mt-4 mb-2">ETHNICITIES</div>
              <div
                class="text-justify"
                v-html="
                  ancestryStore.getAncestry.description.find(
                    (f) => f.name === 'Ethnicities'
                  ).entry
                "
              ></div>
            </div>
          </div>
          <Divider layout="vertical" />
          <div class="w-1/4 relative">
            <div class="pb-4">
              <div class="font-bold">hit points</div>
              <div>{{ ancestryStore.getAncestry.hp }}</div>
            </div>
            <div class="pb-4">
              <div class="font-bold">size</div>
              <div v-for="size in ancestryStore.getAncestry.sizes" :key="size">
                {{ size.toLowerCase() }}
              </div>
            </div>
            <div class="pb-4">
              <div class="font-bold">speed</div>
              <div
                v-for="(speed, type) in ancestryStore.getAncestry.speed"
                :key="type"
              >
                <span v-if="speed != null"
                  >{{ type.toLowerCase() }}: {{ speed }} ft</span
                >
              </div>
            </div>
            <div class="pb-4">
              <div class="font-bold">ability boosts</div>
              <div
                v-for="boost in ancestryStore.getAncestry.abilityBoosts.filter(
                  (ab) => !ab.flaw
                )"
                :key="ancestryStore.getAncestry.abilityBoosts.indexOf(boost)"
              >
                {{ formatAbilityScore(boost.abilityScore) }}
              </div>
            </div>
            <div
              class="pb-4"
              v-if="
                ancestryStore.getAncestry.abilityBoosts.filter((ab) => ab.flaw)
                  .length > 0
              "
            >
              <div class="font-bold">ability flaw</div>
              <div
                v-for="boost in ancestryStore.getAncestry.abilityBoosts.filter(
                  (ab) => ab.flaw
                )"
                :key="ancestryStore.getAncestry.abilityBoosts.indexOf(boost)"
              >
                {{ formatAbilityScore(boost.abilityScore) }}
              </div>
            </div>
            <div class="pb-4">
              <div class="font-bold">languages</div>
              <div
                v-for="language in ancestryStore.getAncestry.knownLanguages"
                :key="
                  ancestryStore.getAncestry.knownLanguages.indexOf(language)
                "
              >
                <router-link
                  :to="'/database/language/' + language.id"
                  class="p-link"
                  >{{ language.name }}</router-link
                >
              </div>
              <div>
                Additional languages equal to
                {{
                  ancestryStore.getAncestry.additionalLanguages
                    ? ancestryStore.getAncestry.additionalLanguages + " + "
                    : ""
                }}
                your Intelligence modifier (if it is positive).
              </div>
            </div>
            <div class="pb-4">
              <div class="font-bold">traits</div>
              <div
                v-for="trait in ancestryStore.getAncestry.traits"
                :key="trait.id"
              >
                <router-link
                  :to="'/database/trait/' + trait.id"
                  class="p-link"
                  >{{ trait.name }}</router-link
                >
              </div>
            </div>
            <div class="absolute bottom-0">
              <div class="font-bold">source</div>
              <div>
                {{
                  ancestryStore.getAncestry.source +
                  " pg. " +
                  ancestryStore.getAncestry.page
                }}
              </div>
            </div>
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
import { useAncestryStore } from "@/stores/database/ancestry";
import { formatAbilityScore } from "@/utils/util";
import Card from "primevue/card";
import Divider from "primevue/divider";

const router = useRouter();
const stateStore = useStateStore();
const ancestryStore = useAncestryStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await ancestryStore.fetchOne(params.id);
  stateStore.getBreadcrumbs.push({
    name: "ancestry",
    label: ancestryStore.getAncestry.name,
    params: params,
  });
  stateStore.setLoading(false);
});
</script>

<style scoped>
.p-divider-vertical {
  width: 1px;
  height: auto !important;
}

.p-divider {
  background-color: #e2e2e2;
  height: 1px;
}
</style>
