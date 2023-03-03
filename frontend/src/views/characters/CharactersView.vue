<template>
  <div class="container mx-auto my-4">
    <CharacterPanel
      v-for="character in characterStore.getCharacters"
      :key="character.id"
      :character="character"
    ></CharacterPanel>
  </div>
</template>

<script setup>
import { useStateStore } from "@/stores/state";
import { useCharacterStore } from "@/stores/character";
import { onMounted } from "vue";
import CharacterPanel from "@/components/characters/CharacterPanel.vue";

const stateStore = useStateStore();
const characterStore = useCharacterStore();

onMounted(async () => {
  stateStore.setLoading(true);
  await characterStore.fetchCharacters(stateStore.getUser.id);
  stateStore.setLoading(false);
});
</script>
