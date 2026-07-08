# run.ps1
# Compiles and runs the ProxyPatternExample project independently.

$ErrorActionPreference = "Stop"
$projectName = "ProxyPatternExample"
$testClass = "com.pattern.proxy.ProxyTest"

Write-Host "============================================================" -ForegroundColor Cyan
Write-Host "Running Project: $projectName" -ForegroundColor Cyan
Write-Host "============================================================" -ForegroundColor Cyan

$srcDir = Join-Path $PSScriptRoot "src"
$binDir = Join-Path $PSScriptRoot "bin"

# Recreate the bin directory
if (Test-Path $binDir) {
    Remove-Item -Recurse -Force $binDir
}
New-Item -ItemType Directory -Path $binDir | Out-Null

# Find all Java source files
$javaFiles = Get-ChildItem -Path $srcDir -Filter "*.java" -Recurse | ForEach-Object { $_.FullName }

if ($javaFiles.Count -eq 0) {
    Write-Host "Error: No Java source files found in $srcDir" -ForegroundColor Red
    exit 1
}

try {
    Write-Host "Compiling source files..." -ForegroundColor DarkGray
    & javac -d $binDir $javaFiles
    
    Write-Host "Executing test suite ($testClass)..." -ForegroundColor DarkGray
    Write-Host ""
    & java -cp $binDir $testClass
    Write-Host ""
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "SUCCESS: $projectName completed successfully." -ForegroundColor Green
    } else {
        Write-Host "FAILURE: $projectName failed during execution (Exit Code: $LASTEXITCODE)." -ForegroundColor Red
        exit $LASTEXITCODE
    }
} catch {
    Write-Host "FAILURE: Compilation or execution error. Details: $_" -ForegroundColor Red
    exit 1
}
