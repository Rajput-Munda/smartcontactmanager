package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "contact")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "picture", length = 10000)
    private String picture;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "favorite", nullable = false)
    private boolean favorite = false;

    @Column(name = "website_link", length = 500)
    private String webSiteLink;

    @Column(name = "linkedin_link", length = 500)
    private String linkedinLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();
}


// package com.scm.entities;

// import java.util.ArrayList;
// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity(name = "contact")
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// public class Contact {
       
//     @Id
//     @Column(name = "id", length = 36, nullable = false)
//     private String id;

//     @Column(name = "name", length = 255, nullable = false)
//     private String name;

//     @Column(name = "email", length = 255, nullable = false)
//     private String email;

//     @Column(name = "phone_number", length = 20, nullable = false)
//     private String phoneNumber;

//     @Column(name = "address", length = 500)
//     private String address;

//     @Column(name = "picture", length = 10000)
//     private String picture;

//     @Column(name = "description", length = 2000)
//     private String description;

//     @Column(name = "favorite", nullable = false)
//     private boolean favorite = false;

//     @Column(name = "website_link", length = 500)
//     private String webSiteLink;

//     @Column(name = "linkedin_link", length = 500)
//     private String linkedinLink;

//     //cascade is use for update the data while user delete and create the contact
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;
//     // private List<String> socialLinks = new ArrayList<>();

//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//     private List<SocialLink> links = new ArrayList<>();
// }

