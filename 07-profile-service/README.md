# Microservices
Spring Cloud Security and microservices

Configuration:
<ol>
    <li> Run [03-config-server] </li>
    <li> Run [06-profile-service]
        <ul>
            <li> <b>bootstrap.yml</b> will request [config-server] @<br>
                 spring.cloud.config.uri: http://localhost:8191
            </li> 
            <li>[config-server] requests config from github hosted config
            </li>  
        </ul>
    </li> 
</ol>
