# ShortUrl
creates a short URLs for list of long URLs

# How to run 

After downloading the project, navigate to src folder
`cd src/`
Compile the program 
`javac com/test/*.java`
Run the program with several options 

- `java com.test.TestShortUrl <long URLs>`
   
   EX: `java com.test.TestShortUrl https://google.com/12345678901212agshby https://www.cricketworldcup.com/`

- `java com.test.TestShortUrl -f input.txt` where input.txt is file with list of URLs seperated by newline

- `java com.test.TestShortUrl -u http://www.google.com` 

- `cat input.txt | java com.test.TestShortUrl`

- `cat - | java com.test.TestShortUrl` enter the URLs in newline in the STDIN and end with Cntrl+D



