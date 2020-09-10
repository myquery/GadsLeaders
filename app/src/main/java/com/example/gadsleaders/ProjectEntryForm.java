package com.example.gadsleaders;

public class ProjectEntryForm {
    private String emailAddress;
    private String name;
    private String lastName;
    private String linkToProject;

    public ProjectEntryForm(String emailAddress, String name, String lastName, String linkToProject) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.lastName = lastName;
        this.linkToProject = linkToProject;
    }

    public ProjectEntryForm() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLinkToProject() {
        return linkToProject;
    }

    @Override
    public String toString() {
        return "ProjectEntryForm{" +
                "emailAddress='" + emailAddress + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", linkToProject='" + linkToProject + '\'' +
                '}';
    }
}
