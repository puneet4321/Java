package org.puneet.project.code.patternlearning.binarysearch.bsOnAnswer;

public class AllocateBooksorBookAllocation_6 {
    public static void main(String[] args) {
        int[] books = {25, 46, 28, 49, 24};
        int totalStudent = 4;
        System.out.println(findPages(books, totalStudent));
    }

    public static int findPages(int[] books, int totalStudent) {
        int ans = -1;
        if (books.length < totalStudent) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int pagesInBook : books) {
            low = Math.max(low, pagesInBook);
            high += pagesInBook;
        }
        ans = high;
        while (low <= high) {
            int midPages = low + (high - low) / 2;
            if (allocateBooks(books, midPages, totalStudent)) {
                ans = midPages;
                high = midPages - 1;
            } else low = midPages + 1;
        }
        return ans;
    }

    public static boolean allocateBooks(int[] books, int midPages, int totalStudent) {
        int prevPages = 0;
        int students = 1;
        for (int currPages : books) {
            if (prevPages + currPages <= midPages) {
                prevPages += currPages;
            } else {
                students++;
                prevPages = currPages;
            }
        }
        return students <= totalStudent;
    }
}
