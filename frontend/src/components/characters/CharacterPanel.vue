<template>
  <Panel class="p-1">
    <template #header>
      <div class="text-5xl mb-4">{{ props.character.name }}</div>
    </template>
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
          <span v-for="campaign in props.character.campaigns" :key="campaign.id"
            >{{ campaign.name
            }}<span
              v-if="
                props.character.campaigns.indexOf(campaign) !==
                props.character.campaigns.length - 1
              "
            ></span>
          </span>
        </div>
        <div>
          race:
          {{ props.character.ancestry ? props.character.ancestry.name : "N/A" }}
        </div>
        <div>
          class:
          {{
            props.character.characterClass
              ? props.character.characterClass.name
              : "N/A"
          }}
        </div>
      </div>
      <div class="col-span-2">
        <div class="my-2 flex"><Button label="character sheet"></Button></div>
        <div class="my-2 flex"><Button label="edit"></Button></div>
      </div>
    </div>
  </Panel>
</template>

<script setup>
import Panel from "primevue/panel";
import Button from "primevue/button";

const props = defineProps({
  character: {
    type: Object,
    required: true,
  },
});
</script>

<style scoped>
.p-panel .p-panel-title {
    font-size: 3rem;
    margin-bottom: 1rem;
}

.p-button {
  margin-left: auto;
}
</style>
