folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

job("Tools/CLONE-REPOSITORY") {
	description()
	keepDependencies(false)
	parameters {
		stringParam("GIT_REPOSITORY_URL", "", "Git URL of the repository to clone")
	}
	disabled(false)
	concurrentBuild(false)
	steps {
		shell("git clone ${GIT_REPOSITORY_URL}")
	}
	wrappers {
		preBuildCleanup {
			deleteDirectories(false)
			cleanupParameter()
		}
	}
}

job("Tools/SEED") {
	description()
	keepDependencies(false)
	parameters {
		stringParam("GITHUB_NAME", "", "GitHub repository owner/repo_name (e.g.: \"EpitechIT31000/chocolatine\")")
		stringParam("DISPLAY_NAME", "", "Display name for the job")
	}
	disabled(false)
	concurrentBuild(false)
	steps {
		dsl {
			ignoreExisting(false)
			removeAction("IGNORE")
			removeViewAction("IGNORE")
			lookupStrategy("JENKINS_ROOT")
		}
	}
}