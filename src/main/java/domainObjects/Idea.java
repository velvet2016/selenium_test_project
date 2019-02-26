package domainObjects;

import java.util.List;

public class Idea {
    Long id;
    String title;
    String confidentiality; //todo: use enum for this
    String autor;
    String campaign;
    String submissionDate; //todo: use Date for this
    String state;          //todo: use enum for this
    String description;
    List<String> comments;
    Double discussionAvgRating;
    Long discussionRaters;

    public Idea() {
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(String confidentiality) {
        this.confidentiality = confidentiality;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public Double getDiscussionAvgRating() {
        return discussionAvgRating;
    }

    public void setDiscussionAvgRating(Double discussionAvgRating) {
        this.discussionAvgRating = discussionAvgRating;
    }

    public Long getDiscussionRaters() {
        return discussionRaters;
    }

    public void setDiscussionRaters(Long discussionRaters) {
        this.discussionRaters = discussionRaters;
    }

    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", confidentiality='" + confidentiality + '\'' +
                ", autor='" + autor + '\'' +
                ", campaign='" + campaign + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                ", discussionAvgRating=" + discussionAvgRating +
                ", discussionRaters=" + discussionRaters +
                '}';
    }

    public Idea(String title, String confidentiality, String autor, String campaign, String state, String description) {
        this.title = title;
        this.confidentiality = confidentiality;
        this.autor = autor;
        this.campaign = campaign;
        this.state = state;
        this.description = description;
    }
    //todo: update equals/hashcode to consider all fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Idea idea = (Idea) o;

        if (id != null ? !id.equals(idea.id) : idea.id != null) return false;
        if (title != null ? !title.equals(idea.title) : idea.title != null) return false;
        if (confidentiality != null ? !confidentiality.equals(idea.confidentiality) : idea.confidentiality != null)
            return false;
        if (autor != null ? !autor.equals(idea.autor) : idea.autor != null) return false;
        if (campaign != null ? !campaign.equals(idea.campaign) : idea.campaign != null) return false;
        if (state != null ? !state.equals(idea.state) : idea.state != null) return false;
        return description != null ? description.equals(idea.description) : idea.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (confidentiality != null ? confidentiality.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (campaign != null ? campaign.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
