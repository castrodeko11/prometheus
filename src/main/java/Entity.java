   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "id_exec", nullable = false, unique = true)
   private TestConfig testConfig;
    
   @Id
   @Column(name = "id_exec")
   private Long idExec;

//Table 2

    @Id
    @Column(name = "id_exec")
    @JsonIgnore
    private Long idExec;

  MultipartFile multipartFile = new MockMultipartFile(files.getName(), new FileInputStream(files));

/*
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>3.1.1.RELEASE</version>
		</dependency>
*/
   
