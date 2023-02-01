<template>
  <div class="container mx-auto my-4">
    <Panel
      v-for="character in characterStore.getCharacters"
      :key="character.id"
      :header="character.name"
      class="p-4"
    >
      <div class="grid grid-cols-12 gap-4">
        <div>
          <img
            src="https://media.discordapp.net/attachments/553181588020789251/1066353440852291614/oceaneye.png"
            class="rounded-full"
          />
        </div>
        <div class="col-span-9">
          <div>
            campaigns:
            <span v-for="campaign in character.campaigns" :key="campaign.id"
              >{{ campaign.name
              }}<span
                v-if="
                  character.campaigns.indexOf(campaign) !==
                  character.campaigns.length - 1
                "
              ></span>
            </span>
          </div>
          <div>
            race: {{ character.ancestry ? character.ancestry.name : "N/A" }}
          </div>
          <div>
            class:
            {{
              character.characterClass ? character.characterClass.name : "N/A"
            }}
          </div>
        </div>
        <div class="col-span-2">
          <div class="my-2 flex"><Button label="character sheet"></Button></div>
          <div class="my-2 flex"><Button label="edit"></Button></div>
        </div>
      </div>
    </Panel>
  </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { useCharacterStore } from "@/stores/character";
import { onMounted } from "vue";
import Panel from "primevue/panel";
import Button from "primevue/button";

const userStore = useUserStore();
const characterStore = useCharacterStore();

onMounted(() => {
  characterStore.fetchCharacters(userStore.getUser.id);
});
</script>

<style scoped>
::v-deep(.p-panel) {
  .p-panel-title {
    font-size: 3rem;
    margin-bottom: 1rem;
  }
}
.p-button {
  margin-left: auto;
}
</style>
