import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useUserStore = defineStore("user", () => {
  const user = ref();
  const getUser = computed(() => user);

  return { user, getUser };
});
