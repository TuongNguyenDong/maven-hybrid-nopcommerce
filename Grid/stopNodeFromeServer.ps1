$Username = 'Admin'
$Password = '211093'
$pass = ConvertTo-SecureString -String $Password -AsPlainText -Force
$Cred = New-Object System.Management.Automation.PSCredential -ArgumentList $Username,$pass
    Invoke-Command -ComputerName "DESKTOP-545QPQM" -ScriptBlock {
      Get-Process -Name "java" 
      Stop-Process -Name "java"
} -Credential $Cred -ErrorAction Stop

       

