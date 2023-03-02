import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useBookStore = defineStore("book", () => {
  const toast = useToast();

  const book = ref();
  const books = ref([]);

  const getBook = computed(() => book.value);
  const getBooks = computed(() => books.value);

  const urls = {
    book: (id) => `http://localhost:3000/api/database/book/${id}`,
    books: "http://localhost:3000/api/database/books",
  };

  async function fetchOne(id) {
    try {
      const response = await axios.get(urls.book(id));
      book.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  async function fetchList() {
    try {
      const response = await axios.get(urls.books);
      books.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  return {
    getBook,
    getBooks,
    fetchOne,
    fetchList,
  };
});
