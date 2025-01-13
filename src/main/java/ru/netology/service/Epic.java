package ru.netology.service;

// Задача состоящая из подзадач.
public class Epic extends Task {

    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    //  Переопределение matches
    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks)
            if (subtask.contains(query)) {
                return true;
            }
        return false;
    }
}
