package br.com.santos.vinicius.multithreading.exercises;

import java.util.List;

public class MultiExecutorExercise {
    public class MultiExecutor {

        List<Runnable> tasks;

        // Add any necessary member variables here

        /*
         * @param tasks to executed concurrently
         */
        public MultiExecutor(List<Runnable> tasks) {
            this.tasks = tasks;
        }

        /**
         * Starts and executes all the tasks concurrently
         */
        public void executeAll() {
            for (Runnable task : tasks) {
                Thread thread = new Thread(task);
                thread.start();
            }
        }
    }
}
