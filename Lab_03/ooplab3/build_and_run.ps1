# Compile all Java sources and run the main class (PowerShell)
# Usage: .\build_and_run.ps1

$jdkPath = 'C:\Program Files\Eclipse Adoptium\jdk-17.0.13.11-hotspot\bin'
$srcDir = 'src'
$binDir = 'bin'

if (-Not (Test-Path $binDir)) { New-Item -ItemType Directory -Path $binDir | Out-Null }

Write-Host "Compiling Java sources..."
& "$jdkPath\javac.exe" -d $binDir (Get-ChildItem -Recurse -Filter *.java -Path $srcDir | ForEach-Object { $_.FullName })

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation failed." -ForegroundColor Red
    exit $LASTEXITCODE
}

Write-Host "Compilation succeeded. Running main class question1A.question1A..."
& "$jdkPath\java.exe" -cp $binDir question1A.question1A
